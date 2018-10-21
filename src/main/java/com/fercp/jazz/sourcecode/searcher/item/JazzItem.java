package com.fercp.jazz.sourcecode.searcher.item;

import com.ibm.team.repository.common.IItemHandle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Summary
 *
 * @author Ferat Capar -
 * @version Creation Date : 09.11.2012 10:58
 * @see
 */
public class JazzItem<T extends IItemHandle> {
    private T item;

    public JazzItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public String toString() {
        try {
            if (item == null)
                return "";
            Method getName = item.getClass().getMethod("getName");
            return (String) getName.invoke(item);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

