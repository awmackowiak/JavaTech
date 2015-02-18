package module2;

import java.io.Serializable;

/**
 * Created by artur.mackowiak on 17/02/15.
 */
public interface Entity extends Serializable {

    void setId(Long id);
    Long getId();

}
