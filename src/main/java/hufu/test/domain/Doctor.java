package hufu.test.domain;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor implements Serializable {
    private static final long serialVersionUID = 7362434484284168179L;

    private Long id;

    public String name;

    public int age;
}
