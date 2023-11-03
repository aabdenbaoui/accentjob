package com.abdenan.jobportal.usermanagement.entities;

//package com.abdenan.jobportal.usermanagement.entities;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//
////@Entity
////@Table(name = "USER_LOG")
public class UserLog {
    public UserLog() {
    }
}
////    @Id
////    @Column(name = "user_id")
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private int id;
////    @OneToOne
//    @MapsId
//    @JoinColumn(name = "user_id")
//    private UserAccount userAccount;
//    private LocalDate lastLoginDate;
//    private LocalDate lastJobApplyDate;
//
//    public UserLog() {
//    }
//
//    public UserLog(UserAccount userAccount, LocalDate lastLoginDate, LocalDate lastJobApplyDate) {
//        this.lastLoginDate = lastLoginDate;
//        this.lastJobApplyDate = lastJobApplyDate;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public UserAccount getUserAccount() {
//        return userAccount;
//    }
//
//    public void setUserAccount(UserAccount userAccount) {
//        this.userAccount = userAccount;
//    }
//
//    public LocalDate getLastLoginDate() {
//        return lastLoginDate;
//    }
//
//    public void setLastLoginDate(LocalDate lastLoginDate) {
//        this.lastLoginDate = lastLoginDate;
//    }
//
//    public LocalDate getLastJobApplyDate() {
//        return lastJobApplyDate;
//    }
//
//    public void setLastJobApplyDate(LocalDate lastJobApplyDate) {
//        this.lastJobApplyDate = lastJobApplyDate;
//    }
//
//    @Override
//    public String toString() {
//        return "UserLog{" +
//                "lastLoginDate=" + lastLoginDate +
//                ", lastJobApplyDate=" + lastJobApplyDate +
//                '}';
//    }
//}
//
