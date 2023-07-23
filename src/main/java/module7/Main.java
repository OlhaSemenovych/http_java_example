package module7;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        /*
        IIf you enter 0, received status code will be - 200,
        a site has image for this case too in spite of
        such image is not displayed on the site
         */

        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }

}
