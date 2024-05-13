package ru.job4j.ood.ocp;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateAdapter extends XmlAdapter<String, Calendar> {
    private static final ThreadLocal<DateFormat> DATE_FORMAT
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd:MM:yyyy HH:mm"));

    @Override
    public Calendar unmarshal(String s) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DATE_FORMAT.get().parse(s));
        return cal;
    }

    @Override
    public String marshal(Calendar calendar) {
        return DATE_FORMAT.get().format(calendar.getTime());
    }
}
