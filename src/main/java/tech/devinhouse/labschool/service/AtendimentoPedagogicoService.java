package tech.devinhouse.labschool.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.labschool.dto.AtendimentoPedagogicoResponse;
import tech.devinhouse.labschool.model.Aluno;
import tech.devinhouse.labschool.model.Pedagogo;
import tech.devinhouse.labschool.model.SituacaoMatricula;
import tech.devinhouse.labschool.repository.AlunoRepository;
import tech.devinhouse.labschool.repository.PedagogoRepository;

import java.util.Optional;


@Service
public class AtendimentoPedagogicoService {


