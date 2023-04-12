package by.tnavitski.testbeatdev.model;

/**
 * Конкретно в нашей задаче можно было бы использовать флаг boolean,
 * но принято решение использовать enum статусы для возможности
 * дальнейшего расширения статусов для случаев BUSY, AFK и других
 */
public enum Status {

    ONLINE,
    OFFLINE

}
