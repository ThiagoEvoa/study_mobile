import 'dart:collection';
import 'dart:convert';
import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter_project/data/model/person_model.dart';

class PersonDataSource {
  static final _url = 'https://evoanodebackend.herokuapp.com/api/';
  static HashMap<String, String> _createHeader() {
    var _header = HashMap<String, String>();
    _header["Content-type"] = "application/json; charset=UTF-8";
    return _header;
  }

  retrievePeople() async {
    final response = await Dio().get('${_url}people');

    switch (response.statusCode) {
      case 200:
        {
          return PersonModel.convertPersonModelToList(response.data);
        }
      default:
        return 'Fail to retrieve people';
    }
  }

  savePerson({@required PersonModel personModel}) async {
    final response = await Dio().post('${_url}person',
        data: jsonEncode(personModel),
        options: Options(headers: _createHeader()));

    switch (response.statusCode) {
      case 200:
        {
          return 'Person saved';
        }
      default:
        {
          return 'Fail to save person';
        }
    }
  }

  updatePerson({@required PersonModel personModel}) async {
    final response = await Dio().put('${_url}person',
        data: jsonEncode(personModel),
        options: Options(headers: _createHeader()));

    switch (response.statusCode) {
      case 200:
        {
          return 'Person updated';
        }
      default:
        {
          return 'Fail to update person';
        }
    }
  }

  deletePerson({@required PersonModel personModel}) async {
    final response = await Dio().delete('${_url}person',
        data: jsonEncode(personModel),
        options: Options(headers: _createHeader()));

    switch (response.statusCode) {
      case 200:
        {
          return 'Person deleted';
        }
      default:
        {
          return 'Fail to deleted person';
        }
    }
  }
}
