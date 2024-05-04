package com.meli.obtenerdiploma.repository;

public interface RepositoryLoader {
    public static void LoadData(ILoadble repository)
    {
        repository.load();
    }
}
