package com.example.jwt.model;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "bg_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bg_user.id
     *
     * @mbg.generated Tue May 07 16:16:19 CST 2019
     */
    private int id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bg_user.name
     *
     * @mbg.generated Tue May 07 16:16:19 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bg_user.gender
     *
     * @mbg.generated Tue May 07 16:16:19 CST 2019
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bg_user.identity_card
     *
     * @mbg.generated Tue May 07 16:16:19 CST 2019
     */
    private String identityCard;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bg_user.mobile_phone
     *
     * @mbg.generated Tue May 07 16:16:19 CST 2019
     */
    private String mobilePhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bg_user.balance
     *
     * @mbg.generated Tue May 07 16:16:19 CST 2019
     */
    private BigDecimal balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bg_user.creation_date
     *
     * @mbg.generated Tue May 07 16:16:19 CST 2019
     */
    private Date creationDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bg_user.modification_date
     *
     * @mbg.generated Tue May 07 16:16:19 CST 2019
     */
    private Date modificationDate;

}
