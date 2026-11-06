import java.util.HashMap;
import java.util.Map;

/**
 * Week 11 Practice 4 - Employee ID Lookup in an Unsorted Directory
 *
 * buildLookup: O(n) time once (only re-run on the rare monthly updates).
 * getDepartment: O(1) average time. Space: O(n) for the map.
 * Why: lookups happen dozens of times a day but updates only a few times a month, so paying
 * O(n) memory once to make every query constant-time beats an O(n) linear scan per query.
 */
public class P04_EmployeeIdLookup {

    static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<String, String>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    static String getDepartment(Map<String, String> lookup, String employeeId) {
        String department = lookup.get(employeeId);
        return department != null ? department : "Unknown";
    }

    public static void main(String[] args) {
        String[][] records = {
                {"E245", "Finance"},
                {"E110", "Engineering"},
                {"E390", "Marketing"},
                {"E101", "Engineering"}
        };
        Map<String, String> lookup = buildLookup(records);
        System.out.println("\"" + getDepartment(lookup, "E390") + "\"");
        System.out.println("\"" + getDepartment(lookup, "E999") + "\"");
    }
}
