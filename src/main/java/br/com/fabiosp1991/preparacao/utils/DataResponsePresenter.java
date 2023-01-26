package br.com.fabiosp1991.preparacao.utils;

import br.com.fabiosp1991.preparacao.entities.ImovelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Optional;

public class DataResponsePresenter<T> {
    private T data;
    private MetadataPresenter metadata;

    public T getData() {
        return data;
    }

    public MetadataPresenter getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataPresenter metadata) {
        this.metadata = metadata;
    }

    public DataResponsePresenter<T> withPage(Page<T> parameter, T data){
        if (parameter != null){
            this.data = data;

            if(!parameter.isEmpty()){
                this.metadata = new MetadataPresenter((PageImpl) parameter);
            }
        }

        return this;
    }
}
