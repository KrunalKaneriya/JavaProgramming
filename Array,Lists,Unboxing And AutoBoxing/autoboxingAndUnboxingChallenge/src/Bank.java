import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branches> branchesArrayList;

    Bank() {
        this.branchesArrayList = new ArrayList<Branches>();
    }

    Bank(String bankName) {
        this.bankName = bankName;
        this.branchesArrayList = new ArrayList<Branches>();
        System.out.println("Adding A New Bank Named: " + bankName);
    }

    private int getBranch(Branches branches) {
        return branchesArrayList.indexOf(branches);
    }

    public void printBranches(Branches branches) {
        for (int i=0;i<branchesArrayList.size();i++) {
            System.out.println("The Branch Name is: --> " + branchesArrayList.get(i).getBranchName());
        }
    }
    public void addBranch(String branchName) {
        Branches newbranch = new Branches(branchName);
        branchesArrayList.add(newbranch);
        System.out.println("Added New Branch Named: "+newbranch.getBranchName());
    }

}
