import java.util.Random;

public class CodeGen {
    private String code;
    Random rand = new Random();

    public CodeGen() {
         this.code = Integer.toString(rand.nextInt(9000) + 1000);
    }

    public String getCode() { return code; }

    public boolean checkCode(String input) {
        return input.equals(code);
  
    }
}
