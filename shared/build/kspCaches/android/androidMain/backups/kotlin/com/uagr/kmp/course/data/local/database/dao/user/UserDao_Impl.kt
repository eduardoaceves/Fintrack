package com.uagr.kmp.course.`data`.local.database.dao.user

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.performInTransactionSuspending
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.uagr.kmp.course.`data`.local.model.user.UserEntity
import javax.`annotation`.processing.Generated
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class UserDao_Impl(
  __db: RoomDatabase,
) : UserDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfUserEntity: EntityInsertAdapter<UserEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfUserEntity = object : EntityInsertAdapter<UserEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `users` (`id`,`name`,`email`,`phone`,`role`) VALUES (nullif(?, 0),?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: UserEntity) {
        statement.bindLong(1, entity.id.toLong())
        val _tmpName: String? = entity.name
        if (_tmpName == null) {
          statement.bindNull(2)
        } else {
          statement.bindText(2, _tmpName)
        }
        val _tmpEmail: String? = entity.email
        if (_tmpEmail == null) {
          statement.bindNull(3)
        } else {
          statement.bindText(3, _tmpEmail)
        }
        val _tmpPhone: String? = entity.phone
        if (_tmpPhone == null) {
          statement.bindNull(4)
        } else {
          statement.bindText(4, _tmpPhone)
        }
        val _tmpRole: String? = entity.role
        if (_tmpRole == null) {
          statement.bindNull(5)
        } else {
          statement.bindText(5, _tmpRole)
        }
      }
    }
  }

  public override suspend fun insertUser(user: UserEntity): Long = performSuspending(__db, false, true) { _connection ->
    val _result: Long = __insertAdapterOfUserEntity.insertAndReturnId(_connection, user)
    _result
  }

  public override suspend fun insertUserAndDeleteOld(user: UserEntity): Unit = performInTransactionSuspending(__db) {
    super@UserDao_Impl.insertUserAndDeleteOld(user)
  }

  public override suspend fun deleteAllUsers() {
    val _sql: String = "DELETE FROM users"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
