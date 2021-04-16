package {{meta.package}}.infrastructure.database.mongo.{{meta.nameLow}}.query;

import com.rcore.database.mongo.commons.query.AbstractExampleQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import {{meta.package}}.domain.{{meta.nameLow}}.port.filters.{{meta.nameUp}}Filters;

public class FindWithFiltersQuery extends AbstractExampleQuery  {

    private final {{meta.nameUp}}Filters {{meta.nameLow}}Filters;

    public FindWithFiltersQuery({{meta.nameUp}}Filters {{meta.nameLow}}Filters) {
        super({{meta.nameLow}}Filters);
        this.{{meta.nameLow}}Filters = {{meta.nameLow}}Filters;
    }

    @Override
    public Criteria getCriteria() {
        return new Criteria();
    }
}
