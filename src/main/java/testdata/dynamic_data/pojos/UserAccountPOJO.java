package testdata.dynamic_data.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/** Just an example POJO from one of those that will be used in test cases
 * and generated from JSON file */
@AllArgsConstructor
@Builder
public class UserAccountPOJO {

    @Getter
    private String gender;

    @Getter
    private String title;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String dayOfBirth;

    @Getter
    private String monthOfBirth;

    @Getter
    private String yearOfBirth;
}
