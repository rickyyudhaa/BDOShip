package com.odlytium.bdoship.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.odlytium.bdoship.entity.ProgressEntity;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class ProgressDao_Impl implements ProgressDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProgressEntity;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfProgressEntity;

  private final SharedSQLiteStatement __preparedStmtOfInserthave;

  public ProgressDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProgressEntity = new EntityInsertionAdapter<ProgressEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `progressentity_table`(`id`,`id_material`,`haveMaterial`,`reqMaterial`,`id_ship`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProgressEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getId_material());
        stmt.bindLong(3, value.getHaveMaterial());
        stmt.bindLong(4, value.getReqMaterial());
        stmt.bindLong(5, value.getId_ship());
      }
    };
    this.__updateAdapterOfProgressEntity = new EntityDeletionOrUpdateAdapter<ProgressEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `progressentity_table` SET `id` = ?,`id_material` = ?,`haveMaterial` = ?,`reqMaterial` = ?,`id_ship` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProgressEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getId_material());
        stmt.bindLong(3, value.getHaveMaterial());
        stmt.bindLong(4, value.getReqMaterial());
        stmt.bindLong(5, value.getId_ship());
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfInserthave = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE progressentity_table SET haveMaterial = ? WHERE id_ship = ? AND id_material = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(ProgressEntity progressEntity) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfProgressEntity.insert(progressEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(ProgressEntity progressEntity) {
    __db.beginTransaction();
    try {
      __updateAdapterOfProgressEntity.handle(progressEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void inserthave(int have, int shipid, int matid) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfInserthave.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, have);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, shipid);
      _argIndex = 3;
      _stmt.bindLong(_argIndex, matid);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInserthave.release(_stmt);
    }
  }

  @Override
  public List<ProgressEntity> getAll() {
    final String _sql = "SELECT * From progressentity_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdMaterial = _cursor.getColumnIndexOrThrow("id_material");
      final int _cursorIndexOfHaveMaterial = _cursor.getColumnIndexOrThrow("haveMaterial");
      final int _cursorIndexOfReqMaterial = _cursor.getColumnIndexOrThrow("reqMaterial");
      final int _cursorIndexOfIdShip = _cursor.getColumnIndexOrThrow("id_ship");
      final List<ProgressEntity> _result = new ArrayList<ProgressEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ProgressEntity _item;
        final int _tmpId_material;
        _tmpId_material = _cursor.getInt(_cursorIndexOfIdMaterial);
        final int _tmpHaveMaterial;
        _tmpHaveMaterial = _cursor.getInt(_cursorIndexOfHaveMaterial);
        final int _tmpReqMaterial;
        _tmpReqMaterial = _cursor.getInt(_cursorIndexOfReqMaterial);
        final long _tmpId_ship;
        _tmpId_ship = _cursor.getLong(_cursorIndexOfIdShip);
        _item = new ProgressEntity(_tmpId_ship,_tmpId_material,_tmpHaveMaterial,_tmpReqMaterial);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ProgressEntity> getbyshipid(int idship) {
    final String _sql = "SELECT * FROM progressentity_table WHERE id_ship= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idship);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdMaterial = _cursor.getColumnIndexOrThrow("id_material");
      final int _cursorIndexOfHaveMaterial = _cursor.getColumnIndexOrThrow("haveMaterial");
      final int _cursorIndexOfReqMaterial = _cursor.getColumnIndexOrThrow("reqMaterial");
      final int _cursorIndexOfIdShip = _cursor.getColumnIndexOrThrow("id_ship");
      final List<ProgressEntity> _result = new ArrayList<ProgressEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ProgressEntity _item;
        final int _tmpId_material;
        _tmpId_material = _cursor.getInt(_cursorIndexOfIdMaterial);
        final int _tmpHaveMaterial;
        _tmpHaveMaterial = _cursor.getInt(_cursorIndexOfHaveMaterial);
        final int _tmpReqMaterial;
        _tmpReqMaterial = _cursor.getInt(_cursorIndexOfReqMaterial);
        final long _tmpId_ship;
        _tmpId_ship = _cursor.getLong(_cursorIndexOfIdShip);
        _item = new ProgressEntity(_tmpId_ship,_tmpId_material,_tmpHaveMaterial,_tmpReqMaterial);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
