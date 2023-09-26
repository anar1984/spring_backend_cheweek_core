package com.cheweek.spring_backend_cheweek_core.utility.coreentity;


import com.cheweek.spring_backend_cheweek_core.utility.QDate;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
@ToString
@EntityListeners({CoreEntityListener.class})
@MappedSuperclass
public class CoreEntity implements Serializable {
    @Id
    @GeneratedValue(generator ="prod-generator")
    @GenericGenerator(name = "prod-generator",
            strategy = "com.cheweek.spring_backend_cheweek_core.utility.sqlgenerator.IdGenerator")

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
