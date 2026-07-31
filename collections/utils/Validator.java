package collections.utils;

import collections.entities.Course;

import java.util.Arrays;
import java.util.HashSet;

public final class Validator {
    private Validator() {
    }

    public static boolean validateCode(String code) {
        return code != null && code.matches(Constants.COURSE_CODE_REGEX);
    }

    /*public static boolean isDuplicatedCode(String code, ArrayList<Course> courses) {
        return courses.stream().anyMatch(c -> c.getCode().equalsIgnoreCase(code));
    }*/
    // update use HashSet
    public static boolean isDuplicatedCode(Course course, HashSet<Course> courses) {
        return courses.contains(course);
    }
    public static boolean validateFlag(String flag) {
        if (flag == null) return false;
        String normalizedFlag = flag.trim();
        return Arrays.stream(Constants.ALLOWED_FLAGS)
                .anyMatch(a -> a.equalsIgnoreCase(normalizedFlag));
    }

    public static boolean validateDuration(short duration) {
        return duration > 0;
    }
}
