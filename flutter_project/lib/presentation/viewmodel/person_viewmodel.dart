import 'package:flutter/material.dart';
import 'package:flutter_project/data/model/person_model.dart';
import 'package:flutter_project/domain/usecase/person_usecase.dart';
import 'package:flutter_project/presentation/widget/dialog.dart';

class PersonViewModel extends ChangeNotifier {
  PersonUseCase _personUseCase = PersonUseCase();
  List<PersonModel> _people;
  String _message;

  List<PersonModel> get getPeople => _people;
  String get getMessage => _message;

  retrievePeople({@required BuildContext context}) async {
    final result = await _personUseCase.retrievePeople();

    if (result is List<PersonModel>) {
      _people = result;
    } else {
      _message = result;
    }
    notifyListeners();
  }

  savePerson({@required PersonModel personModel, @required BuildContext context}) async{
    final result = await _personUseCase.savePerson(personModel: personModel);
    dialog(context: context, title: 'Error', message: result);
  }

  updatePerson({@required PersonModel personModel, @required BuildContext context}) async{
    final result = await _personUseCase.updatePerson(personModel: personModel);
    dialog(context: context, title: 'Error', message: result);
  }

  deletePerson({@required PersonModel personModel, @required BuildContext context}) async{
    final result = await _personUseCase.deletePerson(personModel: personModel);
    dialog(context: context, title: 'Error', message: result);
  }
}
