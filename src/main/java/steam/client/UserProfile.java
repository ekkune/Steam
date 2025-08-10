package steam.client;

public class UserProfile {
    private String username;
    private String avatar;
    private int level;

    private UserProfile(Builder builder) {
        this.username = builder.username;
        this.avatar = builder.avatar;
        this.level = builder.level;
    }

    public String getUsername() {
        return username;
    }

    public void displayProfile() {
        System.out.println("Profile: " + username + ", Level: " + level + ", Avatar: " + avatar);
    }

    public static class Builder {
        private String username;
        private String avatar;
        private int level;

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder withLevel(int level) {
            this.level = level;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }
    }
}