package org.jfaster.mango.example.functional;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

/**
 * @author ash
 */
@DB
public interface CardDao {

    @ReturnGeneratedId
    @SQL("insert into card(name, sub_card) values(:name, :subCard)")
    public int addCard(Card c);

    @SQL("select name, sub_card from card where id = :1")
    public Card getCardById(int id);

}
