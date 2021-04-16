package {{meta.package}}.infrastructure.database.mongo.{{meta.nameLow}}.query;

import com.rcore.database.mongo.commons.query.ExampleQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;

@RequiredArgsConstructor(staticName = "of")
public class FindByIdQuery implements ExampleQuery {
    private final String id;

    @Override
    public Criteria getCriteria() {
        return Criteria.where("_id").is(id);
    }
}
