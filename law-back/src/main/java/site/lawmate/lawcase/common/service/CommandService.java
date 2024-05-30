package site.lawmate.lawcase.common.service;


import site.lawmate.lawcase.common.component.Messenger;

public interface CommandService<T> {
    Messenger save (T t);
    Messenger deleteById (Long id);
    Messenger modify(T t);
}
