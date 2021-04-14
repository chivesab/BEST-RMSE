public class DeskPhone implements  ITelephone{

    private int mynumber;
    private boolean isRinging;

    @Override
    public void powerOn() {
        System.out.println("This phone hasn't have power bottom ");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now phone "+phoneNumber+" is on the desk ");
    }

    @Override
    public void answer() {
        System.out.println("Answer the phone");
        isRinging = false;
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == mynumber){
            System.out.println("Phone is ringing");
            isRinging = true;
            return true;
        }
        isRinging = false;
        return false;
    }

    @Override
    public boolean isRinging() {
        return false;
    }
}
