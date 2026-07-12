package thread;

import java.util.concurrent.CompletableFuture;

class User {
    private String name;
    private String email;

    User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + "]";
    }
}

public class CompletableFutureExample {
    static void main() {
        CompletableFuture<User> future = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchUserByNameAndEmail("John", "john@gmail.com");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenApply(user -> {
            System.out.println("User fetched " + user.getName());
            user.setName("fetched user " + user.getName());
            return user;
        });

        System.out.println("Returned from future " + future.join());
    }

    private static User fetchUserByNameAndEmail(String name, String email) throws InterruptedException {
        //calling database
        Thread.sleep(100);
        return new User(name, email);
    }
}
