package com.odlytium.bdoship.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.odlytium.bdoship.entity.Ownedprogress;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class OwnedprogressDao_Impl implements OwnedprogressDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfOwnedprogress;

  public OwnedprogressDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOwnedprogress = new EntityInsertionAdapter<Ownedprogress>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ownedprogress_table`(`id`,`id_ship`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ownedprogress value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getId_ship());
      }
    };
  }

  @Override
  public long insert(Ownedprogress ownedprogress) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfOwnedprogress.insertAndReturnId(ownedprogress);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Ownedprogress> getAll() {
    final String _sql = "SELECT * From ownedprogress_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdShip = _cursor.getColumnIndexOrThrow("id_ship");
      final List<Ownedprogress> _result = new ArrayList<Ownedprogress>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Ownedprogress _item;
        final int _tmpId_ship;
        _tmpId_ship = _cursor.getInt(_cursorIndexOfIdShip);
        _item = new Ownedprogress(_tmpId_ship);
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
  public List<Ownedprogress> getbyshipid(int id_ship) {
    final String _sql = "SELECT * FROM ownedprogress_table WHERE id_ship = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id_ship);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdShip = _cursor.getColumnIndexOrThrow("id_ship");
      final List<Ownedprogress> _result = new ArrayList<Ownedprogress>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Ownedprogress _item;
        final int _tmpId_ship;
        _tmpId_ship = _cursor.getInt(_cursorIndexOfIdShip);
        _item = new Ownedprogress(_tmpId_ship);
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
  public Ownedprogress getprogress(int id) {
    final String _sql = "SELECT * FROM ownedprogress_table WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIdShip = _cursor.getColumnIndexOrThrow("id_ship");
      final Ownedprogress _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId_ship;
        _tmpId_ship = _cursor.getInt(_cursorIndexOfIdShip);
        _result = new Ownedprogress(_tmpId_ship);
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
