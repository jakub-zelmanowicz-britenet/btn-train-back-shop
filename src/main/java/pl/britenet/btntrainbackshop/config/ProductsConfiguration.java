package pl.britenet.btntrainbackshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.jakub.adminpanel.service.DatabaseService;
import pl.jakub.adminpanel.service.ProductService;

@Configuration
public class ProductsConfiguration {

    @Bean
    public ProductService getProductsService() {
        DatabaseService databaseService = DatabaseService.getInstance();
        return new ProductService(databaseService);
    }

    @Bean
    public CategoryService getCategoryService() {
        DatabaseService databaseService = DatabaseService.getInstance();
        return new CategoryService(databaseService);
    }

}
