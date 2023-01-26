package br.com.fabiosp1991.preparacao.utils;

import org.springframework.data.domain.PageImpl;

public class MetadataPresenter {
    private PaginationPresenter pagination;

    public MetadataPresenter(PageImpl parameter) {
        if (parameter != null) {
            this.pagination = new PaginationPresenter(parameter);
        }
    }

    public PaginationPresenter getPagination() {
        return pagination;
    }
}
