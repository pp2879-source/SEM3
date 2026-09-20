public class AttendanceSheetDemo {

    static class AttendanceSheet {
        private final String[] presentStudents;
        private int presentCount;

        public AttendanceSheet(int maxClassSize) {
            this.presentStudents = new String[maxClassSize];
            this.presentCount = 0;
        }

        public void markPresent(String name) {
            if (isPresent(name)) {
                return; // already marked, avoid duplicates
            }
            if (presentCount >= presentStudents.length) {
                System.out.println("Cannot mark present: class is full");
                return;
            }
            presentStudents[presentCount] = name;
            presentCount++;
        }

        public int getPresentCount() {
            return presentCount;
        }

        public boolean isPresent(String name) {
            for (int i = 0; i < presentCount; i++) {
                if (presentStudents[i].equals(name)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}
