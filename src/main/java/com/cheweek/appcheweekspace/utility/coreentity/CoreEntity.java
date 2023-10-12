package com.cheweek.appcheweekspace.utility.coreentity;

import com.cheweek.appcheweekspace.utility.QDate;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@SuperBuilder
@EntityListeners({CoreEntityListener.class})
@MappedSuperclass
public class CoreEntity implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id;
    @Column(name = "created_by",nullable = false)
    String createdBy ;
    @Column(name = "created_time",nullable = false)
    String createdTime = QDate.getCurrentTime();
    @Column(name = "status",nullable = false)
    String status ;
    @Column(name = "insert_date",nullable = false)
    String insertDate = QDate.getCurrentDate();
    @Column(name = "modification_date")
    String modificationDate;
    @Column(name = "modification_time")
    String modificationTime;
    @Column(name = "created_date",nullable = false)
    String createdDate = QDate.getCurrentDate();
    @Column(name = "modification_by")
    String modificationBy ;

}
