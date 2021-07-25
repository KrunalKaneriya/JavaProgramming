public class ScopeCheck {
    public int publicVar = 0;
    private int varOne =1;

    public ScopeCheck() {
        System.out.println("Scopecheck created , publicVar = "  + publicVar + " varOne = "+ varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() {
        int varTwo = 2;
        for(int i=1;i<=10;i++) {
            System.out.println(i+ " Times Two is " + (i * varTwo));
//            System.out.println(i+ " Times Two is " + (i * this.varTwo));
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer Class: " + innerClass.varThree);
    }


    public class InnerClass {
        public int varThree  = 3;
        public InnerClass() {
            System.out.println("InnerClass Created, varOne is " + varOne + " and varThree is " + varThree);
        }

        public void timesTwo() {
            System.out.println("Var one is still available here..");
            for(int i=1;i<=10;i++) {
                System.out.println(varOne+ " Times "+i+" is " + (i * varThree));
            }
        }
    }




}
