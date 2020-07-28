package com.odlytium.bdoship.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.odlytium.bdoship.entity.Ship;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class ShipDao_Impl implements ShipDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfShip;

  public ShipDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfShip = new EntityInsertionAdapter<Ship>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ship_table`(`id`,`type`,`material`,`icon`,`inventory`,`cabins`,`cannonballs`,`cannons`,`lt`,`speed`,`turn`,`accel`,`brake`,`reload`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ship value) {
        stmt.bindLong(1, value.getId());
        if (value.getType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getType());
        }
        if (value.getMaterial() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMaterial());
        }
        stmt.bindLong(4, value.getIcon());
        stmt.bindLong(5, value.getInventory());
        stmt.bindLong(6, value.getCabins());
        stmt.bindLong(7, value.getCannonballs());
        stmt.bindLong(8, value.getCannons());
        stmt.bindLong(9, value.getLt());
        stmt.bindLong(10, value.getSpeed());
        stmt.bindLong(11, value.getTurn());
        stmt.bindLong(12, value.getAccel());
        stmt.bindLong(13, value.getBrake());
        stmt.bindLong(14, value.getReload());
      }
    };
  }

  @Override
  public void insert(Ship ship) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfShip.insert(ship);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Ship> getAll() {
    final String _sql = "SELECT * From ship_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final int _cursorIndexOfMaterial = _cursor.getColumnIndexOrThrow("material");
      final int _cursorIndexOfIcon = _cursor.getColumnIndexOrThrow("icon");
      final int _cursorIndexOfInventory = _cursor.getColumnIndexOrThrow("inventory");
      final int _cursorIndexOfCabins = _cursor.getColumnIndexOrThrow("cabins");
      final int _cursorIndexOfCannonballs = _cursor.getColumnIndexOrThrow("cannonballs");
      final int _cursorIndexOfCannons = _cursor.getColumnIndexOrThrow("cannons");
      final int _cursorIndexOfLt = _cursor.getColumnIndexOrThrow("lt");
      final int _cursorIndexOfSpeed = _cursor.getColumnIndexOrThrow("speed");
      final int _cursorIndexOfTurn = _cursor.getColumnIndexOrThrow("turn");
      final int _cursorIndexOfAccel = _cursor.getColumnIndexOrThrow("accel");
      final int _cursorIndexOfBrake = _cursor.getColumnIndexOrThrow("brake");
      final int _cursorIndexOfReload = _cursor.getColumnIndexOrThrow("reload");
      final List<Ship> _result = new ArrayList<Ship>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Ship _item;
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final String _tmpMaterial;
        _tmpMaterial = _cursor.getString(_cursorIndexOfMaterial);
        final int _tmpIcon;
        _tmpIcon = _cursor.getInt(_cursorIndexOfIcon);
        final int _tmpInventory;
        _tmpInventory = _cursor.getInt(_cursorIndexOfInventory);
        final int _tmpCabins;
        _tmpCabins = _cursor.getInt(_cursorIndexOfCabins);
        final int _tmpCannonballs;
        _tmpCannonballs = _cursor.getInt(_cursorIndexOfCannonballs);
        final int _tmpCannons;
        _tmpCannons = _cursor.getInt(_cursorIndexOfCannons);
        final int _tmpLt;
        _tmpLt = _cursor.getInt(_cursorIndexOfLt);
        final int _tmpSpeed;
        _tmpSpeed = _cursor.getInt(_cursorIndexOfSpeed);
        final int _tmpTurn;
        _tmpTurn = _cursor.getInt(_cursorIndexOfTurn);
        final int _tmpAccel;
        _tmpAccel = _cursor.getInt(_cursorIndexOfAccel);
        final int _tmpBrake;
        _tmpBrake = _cursor.getInt(_cursorIndexOfBrake);
        final int _tmpReload;
        _tmpReload = _cursor.getInt(_cursorIndexOfReload);
        _item = new Ship(_tmpType,_tmpMaterial,_tmpIcon,_tmpInventory,_tmpCabins,_tmpCannonballs,_tmpCannons,_tmpLt,_tmpSpeed,_tmpTurn,_tmpAccel,_tmpBrake,_tmpReload);
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
  public Ship getbyshipid(long id_ship) {
    final String _sql = "SELECT * FROM ship_table WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id_ship);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final int _cursorIndexOfMaterial = _cursor.getColumnIndexOrThrow("material");
      final int _cursorIndexOfIcon = _cursor.getColumnIndexOrThrow("icon");
      final int _cursorIndexOfInventory = _cursor.getColumnIndexOrThrow("inventory");
      final int _cursorIndexOfCabins = _cursor.getColumnIndexOrThrow("cabins");
      final int _cursorIndexOfCannonballs = _cursor.getColumnIndexOrThrow("cannonballs");
      final int _cursorIndexOfCannons = _cursor.getColumnIndexOrThrow("cannons");
      final int _cursorIndexOfLt = _cursor.getColumnIndexOrThrow("lt");
      final int _cursorIndexOfSpeed = _cursor.getColumnIndexOrThrow("speed");
      final int _cursorIndexOfTurn = _cursor.getColumnIndexOrThrow("turn");
      final int _cursorIndexOfAccel = _cursor.getColumnIndexOrThrow("accel");
      final int _cursorIndexOfBrake = _cursor.getColumnIndexOrThrow("brake");
      final int _cursorIndexOfReload = _cursor.getColumnIndexOrThrow("reload");
      final Ship _result;
      if(_cursor.moveToFirst()) {
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final String _tmpMaterial;
        _tmpMaterial = _cursor.getString(_cursorIndexOfMaterial);
        final int _tmpIcon;
        _tmpIcon = _cursor.getInt(_cursorIndexOfIcon);
        final int _tmpInventory;
        _tmpInventory = _cursor.getInt(_cursorIndexOfInventory);
        final int _tmpCabins;
        _tmpCabins = _cursor.getInt(_cursorIndexOfCabins);
        final int _tmpCannonballs;
        _tmpCannonballs = _cursor.getInt(_cursorIndexOfCannonballs);
        final int _tmpCannons;
        _tmpCannons = _cursor.getInt(_cursorIndexOfCannons);
        final int _tmpLt;
        _tmpLt = _cursor.getInt(_cursorIndexOfLt);
        final int _tmpSpeed;
        _tmpSpeed = _cursor.getInt(_cursorIndexOfSpeed);
        final int _tmpTurn;
        _tmpTurn = _cursor.getInt(_cursorIndexOfTurn);
        final int _tmpAccel;
        _tmpAccel = _cursor.getInt(_cursorIndexOfAccel);
        final int _tmpBrake;
        _tmpBrake = _cursor.getInt(_cursorIndexOfBrake);
        final int _tmpReload;
        _tmpReload = _cursor.getInt(_cursorIndexOfReload);
        _result = new Ship(_tmpType,_tmpMaterial,_tmpIcon,_tmpInventory,_tmpCabins,_tmpCannonballs,_tmpCannons,_tmpLt,_tmpSpeed,_tmpTurn,_tmpAccel,_tmpBrake,_tmpReload);
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
