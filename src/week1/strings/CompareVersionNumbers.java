package week1.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Compare two version numbers version1 and version2.
 *
 * If version1 > version2 return 1,
 * If version1 < version2 return -1,
 * otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 *
 * Created by Elmira Andreeva on 7/14/17.
 */
public class CompareVersionNumbers {

    public int compareVersion(String a, String b) {
        if (a == null && b == null) return 0;
        if (a == null && b != null) return -1;
        if (a != null && b == null) return 1;

        List<String> vers1 = getParsedVersions(a);
        List<String> vers2 = getParsedVersions(b);

        int i = 0, j = 0;

        while (i < vers1.size() && j < vers2.size()) {
            if (vers1.get(i).length() < vers2.get(j).length()) return -1;
            else if (vers1.get(i).length() > vers2.get(j).length()) return 1;
            else {
                for (int k = 0; k < vers1.get(i).length(); k++) {
                    if (vers1.get(i).charAt(k) < vers2.get(j).charAt(k)) return -1;
                    else if (vers1.get(i).charAt(k) > vers2.get(j).charAt(k)) return 1;
                }
                i++;
                j++;
            }
        }
        if (i == vers1.size() && j == vers2.size()) return 0;
        return i == vers1.size() ? -1 : 1;
    }

    private List<String> getParsedVersions(String str) {
        int start = -1, end = -1;
        List<String> list = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                if (start >= 0) {
                    list.add(str.substring(start, i));
                    start = -1;
                }
            } else if (start == -1 && str.charAt(i) != '0') start = i;
        }
        if (start >= 0 && start < str.length()) list.add(str.substring(start, str.length()));
        return list;
    }


}
