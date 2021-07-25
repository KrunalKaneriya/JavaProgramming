public class TryWithResources {
    public static void main(String[] args) throws Exception{
        try(Bar b = new Bar();Foo f = new Foo()) {
            b.doSomething();
            f.doSomething();
        } catch(Exception ex) {
            System.out.println("In Catch Block " + ex);
            ex.printStackTrace();
        } finally{
            System.out.println("In Finally");
            throw new Exception("In Finally Block");
        }
    }
}

class Bar implements AutoCloseable {
    public Bar() {
        System.out.println("Inside Bar Class..");
    }

    public void doSomething() {
        System.out.println("Do Something In Bar");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed Bar");
    }
}

class Foo implements AutoCloseable {

    public Foo(){
        System.out.println("Inside Foo Class");
    }

    public void doSomething() throws Exception{
        throw new Exception("Exception from Foo doSomething() method");
    }

    @Override
    public void close() throws Exception{
        System.out.println("Closing Foo");
        throw new Exception("Unable to close Foo...");
    }
}
