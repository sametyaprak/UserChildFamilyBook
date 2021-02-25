package springboot.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.entity.Family;
import springboot.repository.FamilyRepository;

@Component
public class FamilyDataFetcher implements DataFetcher<Family> {

    @Autowired
    FamilyRepository familyRepository;


    @Override
    public Family get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        Long id = dataFetchingEnvironment.getArgument("familyId");
        return familyRepository.getOne(id);
    }
}
