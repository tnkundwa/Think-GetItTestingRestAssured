package pojo.response;

import lombok.Data;

//@Data
//public class User {
//    private String id;
//
//    private String email;
//
//    private String firstName;
//
//    private String lastName;
//
//    private String role;
//
//    private Boolean isVerified;
//
//    private String avatar;
//
//    private String phone;
//
//    private String createdAt;
//}

@Data
public class User {
    private String id;

    private String email;

    private String firstName;

    private String lastName;

    private String role;

    private Boolean isVerified;

    private Object resetTokenExpiry;

    private Object avatar;

    private String phone;

    private String createdAt;

    private String updatedAt;
}
