package com.qiyue.shopsyn.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.util.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

public class ExcelExportUtils {
    private static final int SHEET_SIZE_LIMIT = 60000;

    /**
     * 将集合数据导出成excel字节xls格式
     *
     * @param <T>  类型
     * @param data 集合数据
     */
    public static <T> byte[] export2Byte(Collection<T> data) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        if (data == null || data.isEmpty()) {
            workbook.createSheet("无数据");
            workbook.write(out);
            return out.toByteArray();
        }
        T next = data.iterator().next();
        List<Field> list = sortedExcelFields(next.getClass());
        ExcelSheet excelSheet = next.getClass().getDeclaredAnnotation(ExcelSheet.class);
        String sheetNamePrefix = (excelSheet == null || excelSheet.value().isEmpty()) ? next.getClass().getName() : excelSheet.value();
        HSSFSheet sheet = null;
        int sheetCount = 0;
        int rownum = 0;
        for (T t : data) {
            if (rownum % SHEET_SIZE_LIMIT == 0) {
                sheetCount++;
                sheet = workbook.createSheet(sheetNamePrefix + sheetCount);
                writeTitle(sheet, list);
                rownum = 0;
            }
            rownum++;
            HSSFRow row = sheet.createRow(rownum);
            int columnindex = 0;
            for (Field f : list) {
                Object o = getProperty(t, f.getName());
                Cell cell = row.createCell(columnindex++, CellType.STRING);
                ExcelCell excelCell = f.getDeclaredAnnotation(ExcelCell.class);
                if (excelCell.valueAdaptor() != Adaptor.AdaptorDefault.class) {
                    try {
                        Adaptor adaptor = excelCell.valueAdaptor().newInstance();
                        o = adaptor.adaptor(o);
                        cell.setCellValue(get(o));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (o != null && o instanceof Date) {
                    if (StringUtils.hasText(excelCell.pattern())) {
                        cell.setCellValue(DateUtil.formatDate(excelCell.pattern(), (Date) o));
                    } else {
                        cell.setCellValue(get(o));
                    }
                } else {
                    cell.setCellValue(get(o));
                }
            }
        }
        workbook.write(out);
        return out.toByteArray();
    }

    private static String get(Object v) {
        if (v == null) {
            return "";
        } else {
            return String.valueOf(v);
        }
    }

    private static void writeTitle(HSSFSheet sheet, List<Field> fields) {
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < fields.size(); i++) {
            Field f = fields.get(i);
            Cell cell = row.createCell(i, CellType.STRING);
            ExcelCell excelCell = f.getDeclaredAnnotation(ExcelCell.class);
            cell.setCellValue(excelCell != null && !excelCell.value().isEmpty() ? excelCell.value() : f.getName());
        }
    }

    /**
     * 排序
     *
     * @param t   实例类
     * @param <T> 类型
     * @return 排序后的字段列表
     */
    private static <T> List<Field> sortedExcelFields(Class<T> t) {
        List<Field> fields = getExcelFields(t);
        fields.sort(Comparator.comparingInt(o -> o.getDeclaredAnnotation(ExcelCell.class).index()));
        return fields;
    }

    /**
     * excel字段列表
     *
     * @param t 实例
     * @return excel字段列表
     */
    private static List<Field> getExcelFields(Class<?> t) {
        List<Field> fields = new ArrayList<>();
        for (Class<?> clazz = t; clazz != Object.class && clazz != Class.class && clazz != Field.class; clazz = clazz.getSuperclass()) {
            try {
                Stream.of(clazz.getDeclaredFields()).
                        filter(field -> field.isAnnotationPresent(ExcelCell.class)).
                        forEach(fields::add);
            } catch (SecurityException ignore) {
            }
        }
        return fields;
    }

    private static <T> Object getProperty(T t, String propertyName) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, t.getClass());
            Method method = propertyDescriptor.getReadMethod();
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(t);
        } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            throw new RuntimeException("获取属性值失败" + e.getMessage(), e);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface ExcelCell {
        /**
         * 顺序 default 100
         *
         * @return 顺序
         */
        int index() default 0;

        /**
         * 列名
         *
         * @return 列名
         */
        String value() default "";

        /**
         * 格式化模式date类型
         *
         * @return 格式化模式
         */
        String pattern() default "";

        /**
         * 格式转换
         */
        Class<? extends Adaptor> valueAdaptor() default Adaptor.AdaptorDefault.class;
    }

    public interface Adaptor<T> {

        Object adaptor(T t);

        class AdaptorDefault<T> implements Adaptor<T> {
            @Override
            public Object adaptor(T data) {
                return data;
            }
        }
    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface ExcelSheet {

        /**
         * sheet名
         *
         * @return sheet名
         */
        String value() default "";
    }

    @ExcelSheet("人民")
    private static class Man {

        @ExcelCell(value = "年龄", index = 2, valueAdaptor = AgeAdaptor.class)
        private int age;
        @ExcelCell(value = "姓名", index = 1)
        private String name;
        @ExcelCell(value = "日期", index = 3, pattern = "yyyyMMdd HH:mm:ss")
        private Date date;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    public static class AgeAdaptor implements Adaptor<Integer> {
        public AgeAdaptor() {
        }

        @Override
        public Object adaptor(Integer integer) {
            if (integer > 18) {
                return "成年人";
            } else if (integer > 60) {
                return "老年人";
            }
            return "儿童";
        }
    }

    public static class TimeAdaptor implements Adaptor<Integer> {
        public TimeAdaptor() {
        }

        @Override
        public Object adaptor(Integer seconds) {
            String result = "";
            String hour_s = "";
            String minute_s = "";
            String second_s = "";
            int hour = seconds/(60 * 60);
            int minute = (seconds - 3600 * hour)/(60);
            int second = seconds % (60);
            if(hour >= 0 && hour < 10){
                hour_s = "0" + hour;
            }else {
                hour_s = hour + "";
            }
            if(minute >= 0 && minute < 10){
                minute_s = "0" + minute;
            }else {
                minute_s = minute + "";
            }
            if(second >= 0 && second < 10){
                second_s = "0" + second;
            }else {
                second_s = second + "";
            }
            return hour_s + ":" + minute_s + ":" + second_s;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Man> ms = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Man m = new Man();
            m.setAge(new Random().nextInt(80));
            m.setName("Alice " + m.getAge());
            m.setDate(new Date());
            ms.add(m);
        }
        byte[] bytes = export2Byte(ms);
        File f = new File("d:/a.xls");
        FileOutputStream outputStream = new FileOutputStream(f);
        outputStream.write(bytes);
        outputStream.close();
    }
}