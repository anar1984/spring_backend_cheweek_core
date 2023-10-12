package com.cheweek.appcheweekspace.erp.entity.info.product;

import com.cheweek.appcheweekspace.utility.coreentity.CoreEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
@ToString
@Entity
@Table(name = "product")
public class Product extends CoreEntity {


    @Column(name = "product_no")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "product_no_seq")
    @SequenceGenerator(name = "product_no_seq",sequenceName = "product_no_sequence",initialValue = 2000,allocationSize = 1)
    String productNo;
    @Column(name = "is_active")
    String isActive;
    @Column(name = "direction", nullable = false)
    String direction;
    @Column(name = "fk_product_type_id", nullable = false)
    String fkProductTypeId;
    @Column(name = "fk_product_category_id", nullable = false)
    String fkProductCategoryId;
    @Column(name = "fk_unit_id", nullable = false)
    String fkUnitId;
    @Column(name = "fk_parent_product_id")
    String fkParentProductId;
    @Column(name = "product_name")
    String productName;
    @Column(name = "custom_product_no")
    String customProductNo;
    @Column(name = "file_url")
    String fileUrl;
    @Column(name = "product_description")
    String productDescription;
    @PrePersist
    private void preInsert(){
        if(this.customProductNo==null||this.customProductNo.isBlank()){
            this.customProductNo = this.productNo;
        }
        if(this.isActive==null||this.isActive.isBlank()){
            this.isActive = this.status;
        }

    }

}
