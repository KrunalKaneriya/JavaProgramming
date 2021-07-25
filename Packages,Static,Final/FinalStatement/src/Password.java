public class Password {
    private static final int key = 56661654;
    private final int encryptedPassword;

    public Password() {
        this.encryptedPassword = 0;
    }
    public Password(int Password) {
        this.encryptedPassword = encryptDecrypt(Password);
    }

    private int encryptDecrypt(int password) {
//        System.out.println("The XOR Operation is: " + (password^key));
        return password ^ key;
    }

    public final void storePassword() {
        System.out.println("Saving password as "+this.encryptedPassword);
    }

    public boolean letMeIn(int password) {
        if(encryptDecrypt(password) == this.encryptedPassword){
            System.out.println("Welcome");
            return true;
        } else{
            System.out.println("You cannot come in..");
            return false;
        }

    }
}
