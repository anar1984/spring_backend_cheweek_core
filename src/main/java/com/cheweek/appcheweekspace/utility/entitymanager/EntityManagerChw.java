package com.cheweek.appcheweekspace.utility.entitymanager;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Data
@Component
public class EntityManagerChw {
    private final String SELECT="SELECT";

    private final String INSERT_INTO="INSERT INTO";

    private final String VALUES="VALUES";

    private final String BRACKET_LEFT="(";

    private final String BRACKET_RIGHT=")";

    private final String END = ";";

    private final String IN = ";";



    private final String COMMA = ",";

    private final String UPDATE ="UPDATE";
    private final String FROM = "FROM";

    private final String WHERE = "WHERE";

    private  final String SEPARATOR = "  ";

    private  final String UPDATE_SET = "SET";

   String entityName;
   String selectedFields;
   String filteredFields;
   String  updatedFields;
    Map<String,String> params;


}
