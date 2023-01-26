package br.com.fabiosp1991.preparacao.utils;

import org.springframework.data.domain.PageImpl;

public class PaginationPresenter {

    private static final long serialVerionUID = 1L;

    private Long offset;
    private Long size;
    private Long totalRecords;
    private Long returnedRecords;

    public PaginationPresenter(PageImpl parameter) {
        if (parameter != null) {
            this.offset = (long) parameter.getNumber();
            this.size = (long) parameter.getSize();
            this.totalRecords = parameter.getTotalElements();
            this.returnedRecords = (long) parameter.getNumberOfElements();
        }
    }

    public Long getOffset() {
        return offset;
    }

    public Long getSize() {
        return size;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public Long getReturnedRecords() {
        return returnedRecords;
    }
}
