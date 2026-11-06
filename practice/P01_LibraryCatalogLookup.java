/**
 * Week 11 Practice 1 - Library Catalog Lookup (binary search on a catalog sorted by ISBN)
 *
 * Complexity: O(log n) time per query, O(1) extra space.
 * Why it fits: queries vastly outnumber updates, so we keep the catalog sorted (paid once, on update)
 * and every lookup gets the fast logarithmic search instead of an O(n) scan.
 */
public class P01_LibraryCatalogLookup {

    static String findBook(String[][] catalog, String targetIsbn) {
        int low = 0, high = catalog.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn); // equal-length numeric strings compare correctly
            if (cmp == 0) return catalog[mid][1];
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] catalog = {
                {"0001112223", "Introduction to Algebra"},
                {"0002223334", "Beginning Python"},
                {"0003334445", "Classic Mythology"},
                {"0004445556", "Data and Society"},
                {"0005556667", "European History"}
        };
        System.out.println("\"" + findBook(catalog, "0003334445") + "\"");
        System.out.println("\"" + findBook(catalog, "0009998887") + "\"");
    }
}
