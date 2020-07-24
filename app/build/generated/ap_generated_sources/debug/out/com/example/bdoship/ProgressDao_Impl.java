package com.example.bdoship;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public final class ProgressDao_Impl implements ProgressDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProgressEntity;

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
  public ProgressEntity getbyshipid(int idship) {
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
      final ProgressEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId_material;
        _tmpId_material = _cursor.getInt(_cursorIndexOfIdMaterial);
        final int _tmpHaveMaterial;
        _tmpHaveMaterial = _cursor.getInt(_cursorIndexOfHaveMaterial);
        final int _tmpReqMaterial;
        _tmpReqMaterial = _cursor.getInt(_cursorIndexOfReqMaterial);
        final long _tmpId_ship;
        _tmpId_ship = _cursor.getLong(_cursorIndexOfIdShip);
        _result = new ProgressEntity(_tmpId_ship,_tmpId_material,_tmpHaveMaterial,_tmpReqMaterial);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
