package ac.kr.ajou.longmethod;

public class LongMethod {

    public boolean doSomething(String social, String name, String password) {

        if (social.length() != 6) {
            logErrorMessage("Social invalid");
        }

        for (int i = 0; i < social.length(); i++) {

            if (!Character.isDigit(social.charAt(i))) {
                logErrorMessage("Social invalid");
            }
        }

        if (name.length() > 5) {
            logErrorMessage("name invalid");
        }

        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                logErrorMessage("name invalid");
            }
        }

        if (password.length() < 9) {
            logErrorMessage("password invalid");
        }


        int passwordDigitalCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                passwordDigitalCount++;
            }
        }

        if (passwordDigitalCount < 2) {
            logErrorMessage("password invalid");
        }

        return true;
    }

    private boolean logErrorMessage() {
        return logErrorMessage("Social invalid");
    }

    private boolean logErrorMessage(String MessageString) {
        System.out.println(MessageString);
        throw new RuntimeException();
    }
}
