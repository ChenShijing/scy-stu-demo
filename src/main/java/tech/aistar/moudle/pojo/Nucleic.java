package tech.aistar.moudle.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_nucleic")

public class Nucleic implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;
    private String username; //姓名

    @Column(columnDefinition = "datetime")
    @JsonFormat(timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate; //创建时间
    private  int status;  //状态
    private  String remark; //备注
    private String url; //地址
}
