package repositories;

import models.Catalog;

public class CatalogRepositoryImpl implements CatalogRepository {

    Catalog catalog = new Catalog();

    @Override
    public void addCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void showCatalog() {
        System.out.println(catalog.getMedias().toString());
    }

}
