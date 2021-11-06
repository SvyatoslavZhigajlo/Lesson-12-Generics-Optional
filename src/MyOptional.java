import java.util.NoSuchElementException;

public class MyOptional<T> {

    private T data;

    private MyOptional(T data) {
        this.data = data;
    }

    public boolean isPresent() {
        boolean result;
        if (data != null) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public T get() {
        if (data == null) {
            throw new NoSuchElementException();
        } else {
            return data;
        }
    }

    public static <T> MyOptional<T> of(T value) {
        if (value == null) {
            throw new NullPointerException();
        } else {
            return new MyOptional<>(value);
        }
    }

    public static <T> MyOptional<T> ofNullable(T value) {
            return new MyOptional<>(value);
    }

    public static <T> MyOptional<T> empty() {
        return new MyOptional<>(null);
    }

    public T orElse(T other){
        if(isPresent()){
            return data;
        }else {
            return other;
        }
    }

    public boolean equals(Object obj){
        boolean result = false;
        if(obj == this){
         result = true;
        }
        if (!(obj instanceof MyOptional)){
            result = false;
        }
        return result;
    }

    public int hashCode (T data){
        int hashCode = hashCode(data);
        return hashCode;
    }

//    public class Consumer extends MyOptional{
//        private Consumer(Object data) {
//            super(data);
//        }
//    }
//    public void ifPresent(Consumer <T> consumer){
//
//
//    }
}