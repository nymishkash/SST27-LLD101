import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Before: " + p.getEmail());

        // no setter exists now; create a new instance with a display name instead
        UserProfile p2 = svc.withDisplayName(p, "VeryLongDisplayNameThatWillBeTrimmedIfItExceedsTheAllowedLength........................................................................");
        System.out.println("After change (email unchanged):  " + p2.getEmail());
        System.out.println("Display name set: " + p2.getDisplayName());
    }
}
