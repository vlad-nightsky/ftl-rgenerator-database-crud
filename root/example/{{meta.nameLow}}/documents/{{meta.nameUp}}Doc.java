package {{meta.package}}.infrastructure.database.mongo.{{meta.nameLow}}.documents;

import com.rcore.database.mongo.commons.document.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class {{meta.nameUp}}Doc extends BaseDocument {
    {{#document.fields}}
    /**
     * {{description}} 
     */
    {{accessModifier}} {{type}} {{name}};
    {{/document.fields}}
    
    {{#innerClases}}
    @Builder
    @Getter
    @Setter
    public static class {{className}} {
        {{#fields}}
        /**
         * {{description}} 
         */
        {{accessModifier}} {{type}} {{name}};
        {{/fields}}
    }
    {{/innerClases}}
}
