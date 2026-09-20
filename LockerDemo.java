public class LockerDemo {

    static class Locker {
        private final int lockerNumber;
        private String code;

        public Locker(int lockerNumber, String code) {
            this.lockerNumber = lockerNumber;
            this.code = code;
        }

        public boolean changeCode(String currentCode, String newCode) {
            if (!code.equals(currentCode)) {
                System.out.println("Change rejected: current code is incorrect");
                return false;
            }
            code = newCode;
            System.out.println("Code changed successfully for locker " + lockerNumber);
            return true;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
